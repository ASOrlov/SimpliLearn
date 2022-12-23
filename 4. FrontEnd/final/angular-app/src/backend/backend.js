var express = require('express');
var cors = require('cors');
var bodyParser = require('body-parser');
var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
  extended: true
}));

app.use(cors());



var answers=[];
var test = [
    {
        "textOfQuestion":"What is result for 2+2?",
        "answerOptions":[
            {"textOfAnswer":"5","isCorrect":false},
            {"textOfAnswer":"4","isCorrect":true},
            {"textOfAnswer":"3","isCorrect":false},
            {"textOfAnswer":"7","isCorrect":false}
        ]
    },
        {"textOfQuestion":"What is the colour of cat Richard?",
        "answerOptions":[
            {"textOfAnswer":"black","isCorrect":false},
            {"textOfAnswer":"green","isCorrect":false},
            {"textOfAnswer":"gray","isCorrect":true},
            {"textOfAnswer":"red","isCorrect":false},
            {"textOfAnswer":"yellow","isCorrect":false}
        ]
    },
        {"textOfQuestion":"How old is me?",
        "answerOptions":[
            {"textOfAnswer":"42","isCorrect":true},
            {"textOfAnswer":"67","isCorrect":false},
            {"textOfAnswer":"32","isCorrect":false},
            {"textOfAnswer":"12","isCorrect":false},
            {"textOfAnswer":"57","isCorrect":false}
        ]
    }
];

app.get('/test', function (req, res) {
   res.send(test);
});

app.get('/answers', function (req, res) {
  res.send(answers);
});



app.post('/addAnswer', function (req, res) {
  console.log(req.body.questionText)
  answers.push({
      questionText: req.body.questionText,
      answerText: req.body.answerText,
      isCorrect:req.body.isCorrect
  });

  console.log(req.body.answerText);
  res.json("answer addedd");
});

var server = app.listen(3002, function () {
  console.log('backend started');
});
