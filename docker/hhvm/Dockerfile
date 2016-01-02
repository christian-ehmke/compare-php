FROM ubuntu:15.10
MAINTAINER Christian Ehmke

WORKDIR /

RUN apt-get update && \
    apt-get install -y software-properties-common && \
    apt-key adv --recv-keys --keyserver hkp://keyserver.ubuntu.com:80 0x5a16e7281be7a449 && \
    add-apt-repository "deb http://dl.hhvm.com/ubuntu $(lsb_release -sc) main" && \
    apt-get update && \
    apt-get install -y hhvm && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ENV HTML /var/www/html

RUN mkdir -p ${HTML}

VOLUME ${HTML}

EXPOSE 9000

CMD ["service", "hhvm", "start", "&"]