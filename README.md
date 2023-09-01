# Testing-project

- Rest API for conducting various tests.
- Based on Spring Boot ecosystem technologies and PostgreSQL database.
- Created for learning purposes.

# Setup and Running

- Use `JDK 17`.
- Use `Apache Maven`.
- Use `Spring Boot 3.1.2`.
- Use `Spring Data`.
- Use Databases `PostgreSQL`.

## Usage

## 1. Get all questions

## Request
### HTTP GET .../questions

**Summary:**  
Returns all questions with answers

### Responses:

```json
[
    {
        "questionText": "Когда необходимо составлять блок-схему программы:",
        "answers": [
            {
                "answerText": "После составления программы",
                "isRightAnswer": false
            },
            {
                "answerText": "До начала составления самой программы",
                "isRightAnswer": true
            },
            {
                "answerText": "В процессе составления программы",
                "isRightAnswer": false
            }
        ]
    },
    {
        "questionText": "Наиболее наглядной формой описания алгоритма является структурно-стилизованный метод:",
        "answers": [
            {
                "answerText": "представление алгоритма в виде схемы",
                "isRightAnswer": true
            },
            {
                "answerText": "словесное описание алгоритма",
                "isRightAnswer": false
            },
            {
                "answerText": "язык программирования высокого уровня",
                "isRightAnswer": false
            }
        ]
    },
]
```

**200 OK**

--------------------------------------------------------------------------

## 2. Add a new question

### HTTP POST .../questions

**Summary:**  
Returns 200 OK and the created new question

**Request Example:**

POST /questions

```json
{
  "questionText": "jjvjvmkvkvbmbmvjgchfxjvlbllnmnngchjc",
  "answers": [
    {"answerText": "ssjhvsjhvsj",
      "isRightAnswer": false
    },
    {"answerText": "djhdjwh",
      "isRightAnswer": true
    },
    {"answerText": "dwlkdnqdnqnqndn",
      "isRightAnswer": false
    }
  ]
}
```

### Responses:

```json
{
  "questionText": "jjvjvmkvkvbmbmvjgchfxjvlbllnmnngchjc",
  "answers": [
    {"answerText": "ssjhvsjhvsj",
      "isRightAnswer": false
    },
    {"answerText": "djhdjwh",
      "isRightAnswer": true
    },
    {"answerText": "dwlkdnqdnqnqndn",
      "isRightAnswer": false
    }
  ]
}
```

**200 OK**

------------------------------------------------------------------------------

## 3. Remove the question

### HTTP DELETE .../questions/{id}

**Summary:**  
Returns 204 NO CONTENT as the confirmation of deleting the question.

### Responses:

**204 NO CONTENT**

--------------------------------------------------------------------------

## 4. Get question by id

### HTTP GET .../questions/{id}

**Summary:**  
Returns 200 OK when it gets the body of the question

### Responses:

```json
{
  "questionText": "jjvjvmkvkvbmbmvjgchfxjvlbllnmnngchjc",
  "answers": [
    {"answerText": "ssjhvsjhvsj",
      "isRightAnswer": false
    },
    {"answerText": "djhdjwh",
      "isRightAnswer": true
    },
    {"answerText": "dwlkdnqdnqnqndn",
      "isRightAnswer": false
    }
  ]
}
```

**200 OK**

--------------------------------------------------------------------------

## 5. Check answers

### HTTP POST .../questions/check

**Summary:**  
Returns 200 OK and gives the number of correct answers

**Request Example:**

POST /questions/check

```json
[
  {
    "question" : "kjucjcjcjcmjcmchcfgfsrxhcjcjggcjgk" ,
    "answer" : "jjhgv"
  },
  {
    "question" : "vtygcyxrxtzerzwrzcgfxfhcjjjvj" ,
    "answer" : "kjjjjjbvvg"
  },
  {
    "question" : "jkibvvvdwwweeedxubiibbbobobobob",
    "answer" : "hhhj"
  },
  {
    "question" : "looonjvfddddddzwwzwszsz",
    "answer" : "kiibuuvucucycyxxrx"
  },
  {
    "question" : "zrzrzrzwtrchvhdblnjfrtoipkjihbtrrg",
    "answer" : "miniibivutcr"
  },
  {
    "question" : "oibobjvrtxxhctrxjboininmkl",
    "answer" : "kpkmlk"
  },
  {
    "question" : "kmnjvdzfghjfghjbnm",
    "answer" : "lkkbutctetr"
  },
  {
    "question" : "sdfghjklwertyuiozxcvbnmdfghjkrtyuiodghjkcvbn",
    "answer" : "fszewzxghcjcyc"
  },
  {
    "question" : "ujyhbtgrfvedcwsazqazrfvujnlplkjhgfd",
    "answer" : "loihyfrdxch"
  },
  {
    "question" : "cvbnmuytgrertyuiolkjhgfdsxcvbnlkjhgertyu",
    "answer" : "olikmyhntgv"
  }
]
```

### Responses:

```json
    6
```

**200 OK**
