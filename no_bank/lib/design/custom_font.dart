import 'package:flutter/material.dart';

/*
 * 1 - Create a new folder at the root project folder (fonts)
 * 2 - Import the font file into the new folder (file .ttf)
 * 3 - Declare the font in the pubspec file
 *
 */

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      title: 'Custom fonts',
      theme: ThemeData(
        fontFamily: 'Open_Sans_Condended'
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Text('Custom fonts'),
      ),
      body: Center(
        child: Text(
          'This is an example',
          style: TextStyle(
            fontFamily: 'Open_Sans_Condended',
            fontSize: 50
          ),
        ),
      )
    );
  }
}
