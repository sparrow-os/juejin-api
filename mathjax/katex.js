// 引入http模块
const http = require('http')
const url = require('url');

const katex = require('katex');
require('katex/contrib/mhchem'); // modify katex module


/**
 * ?formula=
 * %5Cdisplaystyle%20%5Cleft(%20%5Csum_%7Bk%3D1%7D%5En%20a_k%20b_k%20%5Cright)%5E2%20%5Cleq%20%5Cleft(%20%5Csum_%7Bk%3D1%7D%5En%20a_k%5E2%20%5Cright)%20%5Cleft(%20%5Csum_%7Bk%3D1%7D%5En%20b_k%5E2%20%5Cright)
 */
// 创建服务器
const server = http.createServer((req, res) => {
    const params = url.parse(req.url, true).query;
    const formula = params.formula;
    try {
        const html = katex.renderToString(formula);

        res.statusCode = 200;
        res.setHeader('Content-Type', 'image/svg+xml');
        res.end(html);
    } catch (err) {
        console.log(err.message);
    }
})
// 启动服务器监听
server.listen(3000, () => {
    console.log('Server running at http://localhost:3000/');
})
