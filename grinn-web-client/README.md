# GrinnWebClient

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.0.6.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).


Развертывание на Nginx :

    Собрать  Angular приложение:

ng build --prod --base-href=/grinncorp/ --deploy-url=/grinncorp/

    Создать поддиректорию /grinncorp  в директории nginx  /usr/share/nginx/html

    Скопировать поддиректорию Angular приложения /dist в /usr/share/nginx/html/grinncorp

    Отредактировать  nginx конфигурацию (nginx.conf файл в  /etc/nginx/ директории)

server {
	listen       80 default_server;
        root         /usr/share/nginx/html;
        index index.html;

	location /grinncorp/ {
                alias /usr/share/nginx/html/grinncorp/dist/;
                try_files $uri$args $uri$args/ /grinncorp/index.html;
        }
}

    Перезагрузить nginx: nginx -s reload

    Запустить в браузере : http://server_name/grinncorp/

Развертывание на Apache :

    Собрать   Angular приложение:

ng build --prod --base-href=/grinncorp/ --deploy-url=/grinncorp/

    Создать поддиректорию /grinncorp в директории по умолчанию Apache   /var/www/html

    Скопировать из директории Angular  /dist все файлы в  /var/www/html/grinncorp

    Отредактировать Apache конфигурацию (/etc/https/conf/httpd.conf):

sudo vi /etc/httpd/conf/httpd.conf

найти все включения <Directory /var/www/html> и заменить  AllowOverride директиву None  на All:

 /etc/httpd/conf/httpd.conf
 . . .
  <Directory /var/www/html>
 . . .
 # 
 # AllowOverride controls what directives may be placed in .htaccess files.
 # It can be "All", "None", or any combination of the keywords:
 # Options FileInfo AuthConfig Limit
 #
 AllowOverride All
 . . .
 </Directory>
 . . .

    Сохранить и перезагрузить Apache :

sudo systemctl restart httpd

    Создать  .htaccess файл в директории  /var/www/html/grinncorp

sudo vi /var/www/html/grinncorp/.htaccess

Добавить в начало строку для активации правил RewriteEngine:

RewriteEngine On  
# If an existing asset or directory is requested go to it as it is
RewriteCond %{DOCUMENT_ROOT}%{REQUEST_URI} -f [OR]  
RewriteCond %{DOCUMENT_ROOT}%{REQUEST_URI} -d  
RewriteRule ^ - [L]

# If the requested resource doesn't exist, use index.html
RewriteRule ^ index.html  

    Перегрузить Apache:

sudo systemctl restart httpd

    Запустить : http://server_name/grinncorp/

Running unit tests

Run ng test to execute the unit tests via Karma.
Running end-to-end tests

Run ng e2e to execute the end-to-end tests via Protractor. Before running the tests make sure you are serving the app via ng serve.