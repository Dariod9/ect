import 'package:dribbble1/my_flutter_app_icons.dart';
import 'package:flappy_search_bar/flappy_search_bar.dart';
import 'package:flappy_search_bar/search_bar_style.dart';
import 'package:flutter/material.dart';
import 'package:sliding_up_panel/sliding_up_panel.dart';
import 'second.dart';

void main() {
  runApp(const MyApp());
}

class FirstRoute extends StatelessWidget {
  const FirstRoute({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('First Route'),
      ),
      body: Center(
        child: ElevatedButton(
          child: Text('Open route'),
          onPressed: () {
            // Navigate to second route when tapped.
          },
        ),
      ),
    );
  }
}

class SecondRoute extends StatelessWidget {
  const SecondRoute({Key? key}) : super(key: key);

  // Color get cor => cor;


  @override
  Widget build(BuildContext context) {
    return secondPage();
  }
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
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
        primarySwatch: Colors.blueGrey,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
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

  void onPressed() {}
  void onBack() {
    Navigator.pop(context);
  }
  //
  // void travel(){
  //   Navigator.push(
  //     context, MaterialPageRoute(builder: (context) => SecondRoute())
  //   );
  // }

  void _incrementCounter() {
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
      child: Container(
        child: SingleChildScrollView(
          scrollDirection: Axis.vertical,
            child: Column(
          // mainAxisAlignment: MainAxisAlignment.center,
          children: [
            SlidingUpPanel(
              slideDirection: SlideDirection.DOWN ,
                parallaxEnabled: true,
                parallaxOffset: 0.3,
                minHeight: 150,
                maxHeight: 300,
                panel: Container(
                color: Color(0xdddddd).withOpacity(0.5),

              child: Column(
              children: <Widget>[
            Padding(padding: EdgeInsets.only(top: 50)),
            Row(

              children: <Widget>[
                Padding(padding: EdgeInsets.only(left: 20)),

                Flexible(
                  child: SizedBox(
                    // padding: const EdgeInsets.symmetric(horizontal: 20),
                    height: 90,
                    width: 320,
                    child: SearchBar(),
                    )
              ),
                Padding(padding: EdgeInsets.only(left: 20)),
                Icon(
                        Icons.shopping_cart,
                        color: Colors.black45,
                        size: 40
                    )
              ]
            ),
            Padding(padding: EdgeInsets.only(top: 10)),

            Row(
              children: <Widget>[
                Padding(padding: EdgeInsets.only(left: 20)),

                Text(
                "Category", textAlign: TextAlign.left,
                style: TextStyle( fontWeight: FontWeight.bold, fontSize: 20)
              )
              ]
            ),
            Padding(padding: EdgeInsets.only(top: 20)),
            SingleChildScrollView(
              scrollDirection: Axis.horizontal,
              child: Row(
              children: <Widget>[
                Padding(padding: EdgeInsets.only(left: 20)),
                Column(
                  children: <Widget> [
                    TextButton(onPressed: onPressed, child:
                    Container(
                    decoration: BoxDecoration(
                        color: Color(0xffffff).withOpacity(0.5),
                        borderRadius: BorderRadius.all(Radius.circular(12))
                    ),

                      child: SizedBox(
                          height: 50,
                          width: 50,

                          child: Icon(
                          Icons.desktop_mac,
                          color: Colors.black45,
                          size: 30
                        )
                      )
                )),
                    Text(
                        "Desktops", textAlign: TextAlign.left,
                        style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13)
                    ),
                ]
                )
                ,
                Padding(padding: EdgeInsets.only(left: 20)),

                Column(
                    children: <Widget> [
                      TextButton(onPressed: onPressed, child:
                        Container(
                          decoration: BoxDecoration(
                              color: Color(0xffffff).withOpacity(0.5),
                              borderRadius: BorderRadius.all(Radius.circular(12))
                          ),

                          child: SizedBox(
                              height: 50,
                              width: 50,

                              child: Icon(
                                  Icons.smartphone,
                                  color: Colors.black45,
                                  size: 30
                              )
                          )
                      )
                    ),
                      Text(
                          "Smartphones", textAlign: TextAlign.left,
                          style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13)
                      ),
                    ]
                ),
                Padding(padding: EdgeInsets.only(left: 20)),

                Column(
                    children: <Widget> [
                      TextButton(onPressed: onPressed, child:
                      Container(
                          decoration: BoxDecoration(
                              color: Color(0xffffff).withOpacity(0.5),
                              borderRadius: BorderRadius.all(Radius.circular(12))
                          ),

                          child: SizedBox(
                              height: 50,
                              width: 50,

                              child: Icon(
                                  Icons.mouse,
                                  color: Colors.black45,
                                  size: 30
                              )
                          )
                      )),
                      Text(
                          "Accessories", textAlign: TextAlign.left,
                          style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13)
                      ),
                    ]
                ),
                Padding(padding: EdgeInsets.only(left: 20)),
                Column(
                    children: <Widget> [
                      TextButton(onPressed: onPressed, child:
                      Container(
                          decoration: BoxDecoration(
                              color: Color(0xffffff).withOpacity(0.5),
                              borderRadius: BorderRadius.all(Radius.circular(12))
                          ),

                          child: SizedBox(
                              height: 50,
                              width: 50,

                              child: Icon(
                                  Icons.electric_bike_outlined,
                                  color: Colors.black45,
                                  size: 30
                              )
                          )
                      )),
                      Text(
                          "Vehicles", textAlign: TextAlign.left,
                          style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13)
                      ),
                    ]
                ),
                Padding(padding: EdgeInsets.only(left: 20)),
                Column(
                    children: <Widget> [
                      TextButton(onPressed: onPressed, child:
                      Container(
                          decoration: BoxDecoration(
                              color: Color(0xffffff).withOpacity(0.5),
                              borderRadius: BorderRadius.all(Radius.circular(12))
                          ),

                          child: SizedBox(
                              height: 50,
                              width: 50,

                              child: Icon(
                                  Icons.cable,
                                  color: Colors.black45,
                                  size: 30
                              )
                          )
                      )),
                      Text(
                          "Cables", textAlign: TextAlign.left,
                          style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13)
                      ),
                    ]
                )
              ],
            )),
                Padding(padding: EdgeInsets.only(bottom: 10)),
            ]
              )
            )),

             Container(
              child: Column(
              children: <Widget>[
                Padding(padding: EdgeInsets.only(top: 20)),
                Row(
                children: <Widget> [
                  Padding(padding: EdgeInsets.only(left: 20)),
                  Text(
                    "Apple", textAlign: TextAlign.left,
                    style: TextStyle( fontWeight: FontWeight.bold, fontSize: 20)
                      ),
                  Padding(padding: EdgeInsets.only(bottom: 70)),

                ]
                ),
                SingleChildScrollView(
                    scrollDirection: Axis.horizontal,
                child: Row(
                  children: <Widget>[
                    Padding(padding: EdgeInsets.only(left: 20)),

                    TextButton(onPressed: onPressed,
                      child: Container(
                          decoration: BoxDecoration(
                              color: Color(0x0088ff).withOpacity(0.5),
                              borderRadius: BorderRadius.all(Radius.circular(12))
                          ),

                          child: SizedBox(
                              height: 180,
                              width: 160,

                              child : Column(

                               children: <Widget>[
                                 Padding(padding: EdgeInsets.only(top: 20)),

                                 Row(
                                    children: <Widget>[
                                      Padding(padding: EdgeInsets.only(left: 10)),

                                      Text(
                                     "MacBook\nPro".toUpperCase(), textAlign: TextAlign.left,
                                     style: TextStyle( color: Colors.white, fontWeight: FontWeight.bold, fontSize: 17)
                                  )
                                 ]),
                                 Row(children: <Widget>[
                                   Padding(padding: EdgeInsets.only(left: 10)),
                                   Text(
                                       "1,000€".toUpperCase(), textAlign: TextAlign.left,
                                       style: TextStyle( color: Colors.white, fontWeight: FontWeight.bold, fontSize: 12))]),
                                 Image(image: AssetImage('images/macpro.png'), width: 100, height: 100)
                              ]
                              )
                          )
                      ),
                    ),
                    Padding(padding: EdgeInsets.only(left: 20)),

                    TextButton(onPressed: onPressed,
                      child: Container(
                          decoration: BoxDecoration(
                              color: Color(0xee4b4b).withOpacity(0.5),
                              borderRadius: BorderRadius.all(Radius.circular(12))
                          ),

                          child: SizedBox(
                              height: 180,
                              width: 160,

                              child : Column(

                                  children: <Widget>[
                                    Padding(padding: EdgeInsets.only(top: 20)),

                                    Row(
                                        children: <Widget>[
                                          Padding(padding: EdgeInsets.only(left: 10)),

                                          Text(
                                              "iPhone 12".toUpperCase(), textAlign: TextAlign.left,
                                              style: TextStyle( color: Colors.white, fontWeight: FontWeight.bold, fontSize: 17)
                                          )
                                        ]),
                                    Row(children: <Widget>[
                                      Padding(padding: EdgeInsets.only(left: 10)),
                                      Text(
                                        "800€".toUpperCase(), textAlign: TextAlign.left,
                                        style: TextStyle( color: Colors.white, fontWeight: FontWeight.bold, fontSize: 12))]),
                                    Image(image: AssetImage('images/iphone_12.png'), width: 90, height: 90)
                                  ]
                              )
                          )
                      ),
                    ),
                    Padding(padding: EdgeInsets.only(left: 20)),

                    TextButton(onPressed: onPressed,
                      child: Container(
                          decoration: BoxDecoration(
                              color: Color(0x6fc969).withOpacity(0.5),
                              borderRadius: BorderRadius.all(Radius.circular(12))
                          ),

                          child: SizedBox(
                              height: 180,
                              width: 160,

                              child : Column(

                                  children: <Widget>[
                                    Padding(padding: EdgeInsets.only(top: 20)),

                                    Row(
                                        children: <Widget>[
                                          Padding(padding: EdgeInsets.only(left: 10)),

                                          Text(
                                              "iMAC\nPro", textAlign: TextAlign.left,
                                              style: TextStyle( color: Colors.white, fontWeight: FontWeight.bold, fontSize: 17)
                                          )
                                        ]),
                                    Row(children: <Widget>[
                                      Padding(padding: EdgeInsets.only(left: 10)),
                                      Text(
                                          "1,250€".toUpperCase(), textAlign: TextAlign.left,
                                          style: TextStyle( color: Colors.white, fontWeight: FontWeight.bold, fontSize: 12))]),
                                    Image(image: AssetImage('images/mac.png'), width: 100, height: 100)
                                  ]
                              )
                          )
                      ),
                    ),
                    Padding(padding: EdgeInsets.only(left: 20)),

                    TextButton(onPressed: onPressed,
                      child: Container(
                          decoration: BoxDecoration(
                              color: Color(0xc9b169).withOpacity(0.5),
                              borderRadius: BorderRadius.all(Radius.circular(12))
                          ),

                          child: SizedBox(
                              height: 180,
                              width: 160,

                              child : Column(

                                  children: <Widget>[
                                    Padding(padding: EdgeInsets.only(top: 20)),

                                    Row(
                                        children: <Widget>[
                                          Padding(padding: EdgeInsets.only(left: 10)),

                                          Text(
                                              "MacBook\nPro".toUpperCase(), textAlign: TextAlign.left,
                                              style: TextStyle( color: Colors.white, fontWeight: FontWeight.bold, fontSize: 17)
                                          )
                                        ]),
                                    Row(children: <Widget>[
                                      Padding(padding: EdgeInsets.only(left: 10)),
                                      Text(
                                          "400€".toUpperCase(), textAlign: TextAlign.left,
                                          style: TextStyle( color: Colors.white, fontWeight: FontWeight.bold, fontSize: 12))]),
                                    Image(image: AssetImage('images/phones.png'), width: 100, height: 100)
                                  ]
                              )
                          )
                      ),
                    )
                ]
                )
                ),
                Padding(padding: EdgeInsets.only(top: 30)),
                Row(
                    children: <Widget> [
                      Padding(padding: EdgeInsets.only(left: 20)),
                      Text(
                          "Windows", textAlign: TextAlign.left,
                          style: TextStyle( fontWeight: FontWeight.bold, fontSize: 20)
                      ),
                      Padding(padding: EdgeInsets.only(bottom: 20))
              ]
             ),
                Padding(padding: EdgeInsets.only(top: 20)),

              Column(
                    children: <Widget>[
                      Row(
                        children: <Widget>[
                                Padding(padding: EdgeInsets.only(left: 20)),
                                TextButton(onPressed: () {
                                Navigator.push(
                                context, MaterialPageRoute(builder: (context) => SecondRoute())
                                );
                                },
                                  child: Container(
                                      decoration: BoxDecoration(
                                          color: Color(0x6fc969).withOpacity(0.5),
                                          borderRadius: BorderRadius.all(Radius.circular(12))
                                      ),

                                      child: SizedBox(
                                          height: 100,
                                          width: 100,
                                          child: Image(image: AssetImage('images/dell.png'), width: 100, height: 100)
                                          )
                                      ),
                                ),
                          Padding(padding: EdgeInsets.only(left: 20)),
                          SizedBox(
                            height: 100,
                            width: 200,
                            child: Column(
                              children: <Widget>[
                                Padding(padding: EdgeInsets.only(left: 20)),
                                Padding(padding: EdgeInsets.only(top: 20)),

                                Row(
                                    children: <Widget>[ Text(
                                "Dell XPS 13", textAlign: TextAlign.left,
                                style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13)
                                )]),
                                Row(
                                    children: <Widget> [Text(
                                    "1,000€", textAlign: TextAlign.left,
                                    style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13, color: Colors.blue)
                                )])
                              ]
                            ),
                          ),
                           Container(
                                decoration: BoxDecoration(
                                    color: Color(0xdddddd).withOpacity(0.5),
                                    borderRadius: BorderRadius.all(Radius.circular(12))
                                ),

                                child: SizedBox(
                                    height: 50,
                                    width: 50,

                                    child: Icon(
                                        Icons.shopping_cart,
                                        color: Colors.black45,
                                        size: 30
                                    )
                                )
                            ),

                        ]
                      ),
                      Padding(padding: EdgeInsets.only(top: 20)),
                      Row(
                          children: <Widget>[
                            Padding(padding: EdgeInsets.only(left: 20)),
                            TextButton(onPressed: onPressed,
                              child: Container(
                                  decoration: BoxDecoration(
                                      color: Color(0x660000).withOpacity(0.5),
                                      borderRadius: BorderRadius.all(Radius.circular(12))
                                  ),

                                  child: SizedBox(
                                      height: 100,
                                      width: 100,
                                      child: Image(image: AssetImage('images/hp.png'), width: 100, height: 100)
                                  )
                              ),
                            ),
                            Padding(padding: EdgeInsets.only(left: 20)),
                            SizedBox(
                              height: 100,
                              width: 200,
                              child: Column(
                                  children: <Widget>[
                                    Padding(padding: EdgeInsets.only(left: 20)),
                                    Padding(padding: EdgeInsets.only(top: 20)),

                                    Row(
                                        children: <Widget>[ Text(
                                            "HP Omen", textAlign: TextAlign.left,
                                            style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13)
                                        )]),
                                    Row(
                                        children: <Widget> [Text(
                                            "1,000€", textAlign: TextAlign.left,
                                            style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13, color: Colors.blue)
                                        )])
                                  ]
                              ),
                            ),
                                Container(
                                  decoration: BoxDecoration(
                                      color: Color(0xdddddd).withOpacity(0.5),
                                      borderRadius: BorderRadius.all(Radius.circular(12))
                                  ),

                                  child: SizedBox(
                                      height: 50,
                                      width: 50,

                                      child: Icon(
                                          Icons.shopping_cart,
                                          color: Colors.black45,
                                          size: 30
                                      )
                              ),
                            )

                          ]
                      ),
                      Padding(padding: EdgeInsets.only(top: 20)),
                      Row(
                          children: <Widget>[
                            Padding(padding: EdgeInsets.only(left: 30)),
                            Container(
                                decoration: BoxDecoration(
                                    color: Color(0xffd966).withOpacity(0.5),
                                    borderRadius: BorderRadius.all(Radius.circular(12))
                                ),

                                child: SizedBox(
                                    height: 100,
                                    width: 100,
                                    child: Image(image: AssetImage('images/asus.png'), width: 100, height: 100)
                                )
                            ),
                            Padding(padding: EdgeInsets.only(left: 20)),
                            SizedBox(
                              height: 100,
                              width: 200,
                              child: Column(
                                  children: <Widget>[
                                    Padding(padding: EdgeInsets.only(left: 20)),
                                    Padding(padding: EdgeInsets.only(top: 20)),

                                    Row(
                                        children: <Widget>[ Text(
                                            "Asus N550JK", textAlign: TextAlign.left,
                                            style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13)
                                        )]),
                                    Row(
                                        children: <Widget> [Text(
                                            "1,000€", textAlign: TextAlign.left,
                                            style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13, color: Colors.blue)
                                        )])
                                  ]
                              ),
                            ),
                            Container(
                                decoration: BoxDecoration(
                                    color: Color(0xdddddd).withOpacity(0.5),
                                    borderRadius: BorderRadius.all(Radius.circular(12))
                                ),

                                child: SizedBox(
                                    height: 50,
                                    width: 50,

                                    child: Icon(
                                        Icons.shopping_cart,
                                        color: Colors.black45,
                                        size: 30
                                    )
                                )
                            )

                          ]
                      ),
                      Padding(padding: EdgeInsets.only(top: 20)),
                      Row(
                          children: <Widget>[
                            Padding(padding: EdgeInsets.only(left: 30)),
                            Container(
                                decoration: BoxDecoration(
                                    color: Color(0x6fa8dc).withOpacity(0.5),
                                    borderRadius: BorderRadius.all(Radius.circular(12))
                                ),

                                child: SizedBox(
                                    height: 100,
                                    width: 100,
                                    child: Image(image: AssetImage('images/macpro.png'), width: 100, height: 100)
                                )
                            ),
                            Padding(padding: EdgeInsets.only(left: 20)),
                            SizedBox(
                              height: 100,
                              width: 200,
                              child: Column(
                                  children: <Widget>[
                                    Padding(padding: EdgeInsets.only(left: 20)),
                                    Padding(padding: EdgeInsets.only(top: 20)),

                                    Row(
                                        children: <Widget>[ Text(
                                            "MacBook Pro - com Windows :)", textAlign: TextAlign.left,
                                            style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13)
                                        )]),
                                    Row(
                                        children: <Widget> [Text(
                                            "1,000€", textAlign: TextAlign.left,
                                            style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13, color: Colors.blue)
                                        )])
                                  ]
                              ),
                            ),
                            Container(
                                decoration: BoxDecoration(
                                    color: Color(0xdddddd).withOpacity(0.5),
                                    borderRadius: BorderRadius.all(Radius.circular(12))
                                ),

                                child: SizedBox(
                                    height: 50,
                                    width: 50,

                                    child: Icon(
                                        Icons.shopping_cart,
                                        color: Colors.black45,
                                        size: 30
                                    )
                                )
                            )

                          ]
                      ),
                      Padding(padding: EdgeInsets.only(top: 20)),
                      Row(
                          children: <Widget>[
                            Padding(padding: EdgeInsets.only(left: 20)),
                            Container(
                                decoration: BoxDecoration(
                                    color: Color(0x0088ff).withOpacity(0.5),
                                    borderRadius: BorderRadius.all(Radius.circular(12))
                                ),

                                child: SizedBox(
                                    height: 100,
                                    width: 100,
                                    child: Image(image: AssetImage('images/macpro.png'), width: 100, height: 100)
                                )
                            ),

                            Padding(padding: EdgeInsets.only(left: 20)),
                            SizedBox(
                              height: 100,
                              width: 200,
                              child: Column(
                                  children: <Widget>[
                                    Padding(padding: EdgeInsets.only(left: 20)),
                                    Padding(padding: EdgeInsets.only(top: 20)),

                                    Row(
                                        children: <Widget>[ Text(
                                            "Popular", textAlign: TextAlign.left,
                                            style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13)
                                        )]),
                                    Row(
                                        children: <Widget> [Text(
                                            "1,000€", textAlign: TextAlign.left,
                                            style: TextStyle( fontWeight: FontWeight.bold, fontSize: 13, color: Colors.blue)
                                        )])
                                  ]
                              ),
                            ),
                            Container(
                                decoration: BoxDecoration(
                                    color: Color(0xdddddd).withOpacity(0.5),
                                    borderRadius: BorderRadius.all(Radius.circular(12))
                                ),

                                child: SizedBox(
                                    height: 50,
                                    width: 50,

                                    child: Icon(
                                        Icons.shopping_cart,
                                        color: Colors.black45,
                                        size: 30
                                    )
                                )
                            )

                          ]
                      ),
                    ])
              ]
            ))
          ])
        )
        )
      ),
    );
  }
}