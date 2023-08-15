
module.exports = {
  devServer: {
    disableHostCheck: false,
    host: "localhost",
    port: 8082,
    https: false,
    hotOnly: false,
    proxy: null
  },
};



//打包配置文件
module.exports = {
  assetsDir: 'static',
  parallel: false,
  publicPath: './',
};

