import 'package:flutter/material.dart';
import 'Red.dart';

class Blue extends StatefulWidget {
  @override
  State<Blue> createState() {
    return _BlueWidget();
  }
}

class _BlueWidget extends State<Blue> {

  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Blue'),
      ),
      body: SizedBox.expand(
        child: Container(
          color: Colors.blue,
          child: Column(children: [
            RaisedButton(
                onPressed: () {
                  Navigator.push(context,
                      MaterialPageRoute(builder: (context) => Red()   ));
                },
                child: Text('change to red_1')),
            RaisedButton(
                onPressed: () {
                  Navigator.pushNamed(context, '/red');
                },
                child: Text('change to red_2')),
          ]),
        ),
      ),
    );
  }
}
