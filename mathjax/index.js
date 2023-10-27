// 引入http模块
const http = require('http')
const url = require('url');

var MathJax = null;
require('mathjax').init({
    loader: {load: ['input/tex', 'output/svg']}
}).then((_mathJax) => {
    MathJax = _mathJax;
}).catch((err) => console.log("error"));
/**
 * ?formula=
 * %5Cdisplaystyle%20%5Cleft(%20%5Csum_%7Bk%3D1%7D%5En%20a_k%20b_k%20%5Cright)%5E2%20%5Cleq%20%5Cleft(%20%5Csum_%7Bk%3D1%7D%5En%20a_k%5E2%20%5Cright)%20%5Cleft(%20%5Csum_%7Bk%3D1%7D%5En%20b_k%5E2%20%5Cright)
 */
// 创建服务器
const server = http.createServer((req, res) => {
    const params = url.parse(req.url, true).query;
    const formula = params.formula;
    try {
        const svg = MathJax.tex2svg(formula, {display: false});
        res.statusCode = 200;
        res.setHeader('Content-Type', 'image/svg+xml');
        res.end(MathJax.startup.adaptor.outerHTML(svg));
    } catch (err) {
        console.log(err.message);
    }
})
// 启动服务器监听
server.listen(3000, () => {
    console.log('Server running at http://localhost:3000/');
})
