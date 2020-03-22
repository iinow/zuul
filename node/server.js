const express = require('express')
const app = express()

const port = 8084
const users = [
    {
        name: 'AA',
        age: 11
    },
    {
        name: 'BB',
        age: 22
    },
]

app.get('/', (req, res) => {
    res.send("???????뭐냐")
})

app.get('/ha/api/users', (req, res) => {
    res.json(users)
})

app.get('/ha/api/users/:userId', (req, res) => {
    users[0].name = req.params.userId
    res.json(users[0])
})

app.listen(port, () => {
    console.log('node server start')
})