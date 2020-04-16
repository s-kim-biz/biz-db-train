#!/bin/ash

set -e
cd /src

echo 'check Eclipse with ERFlute'
cd ./eclipse
  if [ -e Eclipse.app ];
  then
    echo 'Eclipse.app already exists'
  else
    echo 'download Eclipse with ERFlute'
    wget -O Eclipse.zip https://github.com/ShotaOd/biz-dbtrain/releases/download/release-eclipse/Eclipse.zip
    unzip Eclipse.zip
  fi
cd - > /dev/null

echo 'check DBFlute engine'
mkdir -p ./dbflute-twitterdb/mydbflute
cd ./dbflute-twitterdb/mydbflute
  if [ -e dbflute-1.2.2.zip ];
  then
    echo 'DBFlute engine already exists'
  else
    echo 'download DBFlute engine'
    wget -O dbflute-1.2.2.zip https://github.com/dbflute/dbflute-core/releases/download/dbflute-1.2.2/dbflute-1.2.2.zip
    rm -rf dbflute-1.2.2
    mkdir -p dbflute-1.2.2
    unzip -o dbflute-1.2.2.zip -d dbflute-1.2.2
  fi
cd - > /dev/null
