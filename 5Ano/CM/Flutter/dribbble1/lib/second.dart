import 'package:dribbble1/my_flutter_app_icons.dart';
import 'package:flappy_search_bar/flappy_search_bar.dart';
import 'package:flappy_search_bar/search_bar_style.dart';
import 'package:flutter/material.dart';
import 'package:sliding_up_panel/sliding_up_panel.dart';

Scaffold secondPage(){
  return Scaffold(
    // extendBodyBehindAppBar: true,
    appBar: AppBar(
      title: Text('Dell XPS 13'),
    ),
    body: Center(
      child: Column(
        children: <Widget>[
          Padding(padding: EdgeInsets.only(top: 20)),
          Container(
            alignment: Alignment.center,
            height: 310,
            decoration: BoxDecoration(
                color: Color(0x660000).withOpacity(0.5),
                borderRadius: BorderRadius.only(topLeft: Radius.circular(12), topRight: Radius.circular(12))
            ),
              child: Column(
                  children: <Widget>[
                    Padding(padding: EdgeInsets.only(top: 20)),
                    // Text("Dell XPS 13", style: TextStyle(fontSize: 20, color: Colors.white),),
                    // Text("1000€", style: TextStyle(fontSize: 20, color: Colors.white),),
                    Image(image: AssetImage('images/dell.png'), width: 290, height: 290)
                  ]),

          )
        ,

          Column(
                children: <Widget>[
                  Padding(padding: EdgeInsets.only(top: 20)),
                  Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      Row(
                        children: [
                          Row(
                            children: [
                              Padding(padding: EdgeInsets.only(left: 20)),
                              Text('Dell XPS 13\' ', style: TextStyle(fontWeight: FontWeight.bold),),
                              Padding(padding: EdgeInsets.only(left: 230)),
                              IconButton(onPressed: (){}, icon: Icon(Icons.star)),
                            ],
                          )
                        ],
                      ),
                      Padding(padding: EdgeInsets.only(left: 20)),
                      Text('\nBrand new used computer :D'),
                      Padding(padding: EdgeInsets.only(top: 100)),
                      Row(
                        crossAxisAlignment: CrossAxisAlignment.center,
                        // crossAxisAlignment: CrossAxisAlignment.stretch,
                        children: [
                          Padding(padding: EdgeInsets.only(left: 150)),

                          SizedBox(

                            child: TextButton(onPressed: (){}, child:
                              Container(
                                  decoration: BoxDecoration(
                                  color: Color(0xf1c232).withOpacity(1),
                                  borderRadius: BorderRadius.all(Radius.circular(8))
                              ),
                            child: Text("ADD TO CART", style: TextStyle(color: Colors.white70))
                          ))),
                        ])

                    ]

                  )
                    ]
                  )
        ]
      ),
    ),
    );
}