#!/bin/ash

set -e

cd /src

echo 'wait for DBFlute engine download to complete'
until [ -e ./dbflute-twitterdb/mydbflute/dbflute-1.2.2/product-is-dbflute-1.2.2 ];
do
  echo -n ".";
  sleep 1;
done

cp eclipse/erflute/twitter.sql dbflute-twitterdb/dbflute_twitterdb/playsql/replace-schema.sql

MANAGE_SH=dbflute-twitterdb/dbflute_twitterdb/manage.sh
sh $MANAGE_SH replace-schema <<EOF
y
EOF
sh $MANAGE_SH jdbc
sh $MANAGE_SH doc
