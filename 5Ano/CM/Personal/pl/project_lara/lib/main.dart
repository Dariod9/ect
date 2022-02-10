import 'dart:convert';
import 'dart:io';
import 'dart:math';
import 'package:dropbox_client/dropbox_client.dart';
import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:http/http.dart' as http;
import 'package:image_picker/image_picker.dart';
import 'package:path_provider/path_provider.dart';
import 'package:shared_preferences/shared_preferences.dart';

const String dropbox_clientId = 'PhotosL_99';
const String dropbox_key = 'pz36zkkyg8vt7px';
const String dropbox_secret = '6xqjszgcsw6y9kg';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Appi da Nina',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Appi da Nina'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;
  String? accessToken =
      "27HLw6EqfMoAAAAAAAAAAWUkWpH1VbfhMrnYWyAbFeSVEHaKSwHe6IvIlKIU1Bey";
  final Future<String> account = Future<String>.delayed(
    const Duration(seconds: 2),
    () => 'Data Loaded',
  );
  bool showInstruction = false;
  String resultString = "";
  Future<String?> getTemporaryLink(path) async {
    final result = await Dropbox.getTemporaryLink(path);
    return result;
  }


  var tempDir="";
  bool _visible = true;
  var list = List<dynamic>.empty(growable: true);
  var item;

  @override
  void initState() {
    super.initState();
    authorizeWithAccessToken();

    initDropbox();
    tempDir="";
  }

  Future initDropbox() async {
    if (dropbox_key == 'dropbox_key') {
      showInstruction = true;
      return;
    }

    await Dropbox.init(dropbox_clientId, dropbox_key, dropbox_secret);

    SharedPreferences prefs = await SharedPreferences.getInstance();
    // accessToken = prefs.getString('dropboxAccessToken')!;

    setState(() {});
  }

  Future<bool> checkAuthorized(bool authorize) async {
    final token = await Dropbox.getAccessToken();
    print(token);
    if (token != null) {
      if (accessToken == null || accessToken!.isEmpty) {
        accessToken = token;
        SharedPreferences prefs = await SharedPreferences.getInstance();
        prefs.setString('dropboxAccessToken', accessToken!);
      }
      return true;
    }
    if (authorize) {
      if (accessToken != null && accessToken!.isNotEmpty) {
        await Dropbox.authorizeWithAccessToken(accessToken!);
        final token = await Dropbox.getAccessToken();
        if (token != null) {
          print('authorizeWithAccessToken!');
          return true;
        }
      } else {
        await Dropbox.authorize();
        print('authorize!');
      }
    }
    return false;
  }

  Future authorize() async {
    await Dropbox.authorize();
  }

  // Future unlink() async {
  //   await deleteAccessToken();
  //   await Dropbox.unlink();
  // }

  Future authorizeWithAccessToken() async {
    accessToken =
        "27HLw6EqfMoAAAAAAAAAAWUkWpH1VbfhMrnYWyAbFeSVEHaKSwHe6IvIlKIU1Bey";
    await Dropbox.authorizeWithAccessToken(accessToken!);
  }

  // Future deleteAccessToken() async {
  //   SharedPreferences prefs = await SharedPreferences.getInstance();
  //   prefs.remove('dropboxAccessToken');
  //
  //   setState(() {
  //     accessToken = null;
  //   });
  // }

  Future<String?> getAccountName() async {
    if (await checkAuthorized(true)) {
      final user = await Dropbox.getAccountName();
      print('user = $user');
      return user;
    }
  }

  Future listFolder(path) async {
    // if (await checkAuthorized(true)) {
    authorizeWithAccessToken();
    final result = await Dropbox.listFolder(path);
    setState(() {
      list.clear();
      list.addAll(result);
      print(list);
    });
    // }
  }

  void _incrementCounter() {
    // fetchAlbum();
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  // Future<void> fetchAlbum() async {
  //   final response = await http.get(
  //       Uri.parse('https://photoslibrary.googleapis.com/v1/albums'));
  //   final jsonR = json.decode(response.body);
  //   print(jsonR);
  //   setState(() {
  //     resultString = jsonR['result'];
  //   });
  // }

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: showInstruction
          ? Instructions()
          : Builder(
              builder: (context) {
                return Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: <Widget>[
                    Wrap(
                      children: <Widget>[
                        Column(
                          children: [
                        ElevatedButton(
                            child: Text('Mota 👀'), onPressed: getRandom),
                        Column(children: [
                          AnimatedOpacity(
                              // If the widget is visible, animate to 0.0 (invisible).
                              // If the widget is hidden, animate to 1.0 (fully visible).
                              opacity: _visible ? 1.0 : 0.0,
                              duration: const Duration(milliseconds: 500),
                              // The green box must be a child of the AnimatedOpacity widget.
                              child: _imagem()
                // Image.file(File('${tempDir}'),
                              ),

                        ]),
                        Container(
                          child: getPhrase()
                        )
                          ])],
                    ),

                    // Expanded(
                    //   child: ListView.builder(
                    //     itemCount: list.length,
                    //     itemBuilder: (context, index) {
                    //       final item = list[index];
                    //       final filesize = item['filesize'];
                    //       final path = item['pathLower'];
                    //       bool isFile = false;
                    //       var name = item['name'];
                    //       if (filesize == null) {
                    //         name += '/';
                    //       } else {
                    //         isFile = true;
                    //       }
                    //       return ListTile(
                    //           title: Text(filesize.toString()),
                    //           onTap: () async {
                    //             if (isFile) {
                    //               final link = await getTemporaryLink(path);
                    //               ScaffoldMessenger.of(context).showSnackBar(
                    //                   SnackBar(
                    //                       content: Text(link ??
                    //                           'getTemporaryLink error: $path')));
                    //             } else {
                    //               await listFolder(path);
                    //             }
                    //           });
                    //     },
                    //   ),
                    // ),
                  ],
                );
              },
            ),
    );
  }

  Future<void> getRandom() async {
    Fluttertoast.showToast(
        msg: 'Waitii',
        gravity: ToastGravity.BOTTOM,
        fontSize: 18,
        backgroundColor: Colors.grey,
        textColor: Colors.black);

    await listFolder('');
    Random random = new Random();
    item = random.nextInt(list.length);

    final pic = list[item];
    final filesize = pic['filesize'];
    final path = pic['pathLower'];
    bool isFile = false;
    var name = pic['name'];
    if (filesize == null) {
      name += '/';
    } else {
      isFile = true;
    }

    var t2 = await getTemporaryDirectory();
    var t = '${t2.path}'; // for iOS only!!
    print(tempDir);

    // Directory appDir = await getApplicationDocumentsDirectory();
    final result = await Dropbox.download(path, t+path, (downloaded, total) {
      print('progress $downloaded / $total');
    });

    print(File(t+path).statSync());
    tempDir=t+path;

       setState(() {});
  }

  Widget _imagem() {
    if(tempDir!="") {
      return Image.file(
        File('${tempDir}'));
    }
    else return Image.asset('assets/olhos.png');

  }

  Widget getPhrase() {
    Random r= new Random();
    var inti=r.nextInt(10);
    switch(inti){
      case 0:
        return Text("\nOlhaaa");
      case 1:
        return Text("\nAiiii");
      case 2:
        return Text("\nQue nitaaa");
      case 3:
        return Text("\nGata kkk");
      case 4:
        return Text("\nkkkkkkk");
      case 5:
        return Text("\nNaco 👀");
      case 6:
        return Text("\nJasuuus");
      case 7:
        return Text("\nElaaaaah");
      case 8:
        return Text("\nuiuuuui");
      case 9:
        return Text("\naii olha");
      case 10:
        return Text("\n(olhinhos)");
      default:
        return Text("\nehehe aiii");
    }

  }
}


class Instructions extends StatelessWidget {
  const Instructions({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Text(
              'You need to get dropbox_key & dropbox_secret from https://www.dropbox.com/developers'),
          SizedBox(height: 20),
          Text('1. Update dropbox_key and dropbox_secret from main.dart'),
          SizedBox(height: 20),
          Text(
              "  const String dropbox_key = 'DROPBOXKEY';\n  const String dropbox_secret = 'DROPBOXSECRET';"),
          SizedBox(height: 20),
          Text(
              '2. (Android) Update dropbox_key from android/app/src/main/AndroidManifest.xml.\n  <data android:scheme="db-DROPBOXKEY" />'),
          SizedBox(height: 20),
          Text(
              '2. (iOS) Update dropbox_key from ios/Runner/Info.plist.\n  <string>db-DROPBOXKEY</string>'),
        ],
      ),
    );
  }
}
