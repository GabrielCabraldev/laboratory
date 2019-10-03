import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {

    final appTitle = "Text field style";

    return MaterialApp(
      title: appTitle,
      home: Scaffold(
        appBar: AppBar(
          title: Text(appTitle),
        ),
        body: Padding(
          padding: const EdgeInsets.symmetric(vertical: 16.0),
          child: TextField(
            decoration: InputDecoration(
                border: InputBorder.none,
                hintText: 'Digite algo...'
            ),
          ),
        ),
      ),
    );
  }
}