import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {

    TextField(
      onChanged: (text) {
        print('Digitei $text');
      },
    );

    return MaterialApp(
      title: 'On change example 1',
      home: Scaffold(
        appBar: AppBar(
          title: Text('On change example 1'),
        ),
        body: Column(
          children: [
            TextField(
              onChanged: (text) {
                print('Digitei $text');
              },
            )
          ],
        ),
      ),
    );
  }
}