module.exports = {
  devServer: {
    port: 8080,
    proxy: {
      '/api': {
        target: 'http://localhost:8096/api',
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    },
    disableHostCheck: true
  },
  configureWebpack: {
    devtool: 'source-map'
  },
  /**
   * 修改插件的配置
   * @param config
   */
  chainWebpack: config => {
    config.plugin('html').tap(arg => {
      arg[0].title = 'klbc-blog'
      return arg
    })
  },
  productionSourceMap: false
}
