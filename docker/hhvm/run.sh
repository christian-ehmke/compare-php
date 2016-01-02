docker run \
    --detach \
    --restart always \
    --name demo-hhvm_fastcgi \
    --link mariadb:database \
    --volumes-from demo-hhvm_src \
    cehmke/hhvm

docker cp server.ini demo-hhvm_fastcgi:/etc/hhvm/server.ini
docker cp php.ini demo-hhvm_fastcgi:/etc/hhvm/php.ini

docker restart demo-hhvm_fastcgi