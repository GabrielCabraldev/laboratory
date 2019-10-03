import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      title: 'Snackbar demo',
      home: Scaffold(
        appBar: AppBar(
          title: Text('Snackbar demo'),
        ),
        body: SnackBarPage(),
      ),
    );
  }
}

class SnackBarPage extends StatelessWidget {

  @override
  Widget build(BuildContext context) {

    return Center(
      child: RaisedButton(
        onPressed: () {
          final snackBar = SnackBar(
            content: Text('yeah'),
            action: SnackBarAction(
                label: 'Undo',
                onPressed: () {

                }
            ),
          );
          Scaffold.of(context).showSnackBar(snackBar);
        },
        child: Text('Show Snackbar'),
      ),
    );
  }
}