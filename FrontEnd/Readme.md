# frontend

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Deploys
#### Comandline
```
az login
az webapp up --name FrontEndChatMat --html
```

#### VS Code
* Install plugins: 
  * Azure Account
  * Azure App Service
* Show all comnands: Ctrl + Shift + P 
  * Azure App Service: Deploy to web app...
  * Browse - select dist dir
  * FrontEndChatMat - choose our app
* Deploy - click

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
