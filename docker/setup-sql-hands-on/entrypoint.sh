#!/bin/bash

set -e

echo '=================================================='
echo '𝄞 setup project ♪ wait for git clone'
echo '=================================================='
until [ -e ./tutorial/material/eclipse/prototype-pom.xml ];
do
  echo -n ".";
  sleep 1;
done
echo ''

echo '=================================================='
echo '𝄞 setup project ♪ create pom.xml'
echo '=================================================='
cp tutorial/material/eclipse/prototype-pom.xml ./pom.xml

echo '=================================================='
echo '𝄞 setup DBFlute ♪ install DBFlute Client'
echo '=================================================='
mvn -q -e dbflute:download
mvn -q -e dbflute:create-client

echo '=================================================='
echo '𝄞 setup DBFlute ♪ adjust DBFlute Property'
echo '=================================================='
sed -i'' -e 's/localhost:3306/mysql:3306/g' ./dbflute_maihamadb/dfprop/databaseInfoMap.dfprop
sed -i'' -e 's/localhost:3306/mysql:3306/g' ./dbflute_maihamadb/dfprop/databaseInfoMap.dfprop
sed -i'' -e 's/; user     = maihamadb/; user     = root/g' ./dbflute_maihamadb/dfprop/databaseInfoMap.dfprop
sed -i'' -e 's/; password = maihamadb/; password = /g' ./dbflute_maihamadb/dfprop/databaseInfoMap.dfprop
sed -i'' -e 's/#; quoteTableNameList .*$/;quoteTableNameList = list:{$$ALL$$}/g' dbflute_maihamadb/dfprop/littleAdjustmentMap.dfprop

echo '=================================================='
echo '𝄞 setup DBFlute ♪ locate MaihamaDB playsql'
echo '=================================================='
unzip -o "tutorial/material/dbflute/playsql-*.zip" playsql/* -d dbflute_maihamadb

echo '=================================================='
echo '𝄞 setup DBFlute ♪ setup ReplaceSchema'
echo '=================================================='
rm -f dbflute_maihamadb/playsql/replace-schema.sql
cat << EOF > dbflute_maihamadb/dfprop/replaceSchemaMap.dfprop
map:{
  ; additionalUserMap = map:{
      ; system = map:{
          ; url = jdbc:mysql://mysql:3306
          ; user = root
          ; password = df:dfprop/system-password.txt|
      }
  }
}
EOF
sed -i'' -e "s/localhost/'%'/g" dbflute_maihamadb/playsql/replace-schema-00-system.sql

echo '=================================================='
echo '𝄞 register data ♪ run ReplaceSchema'
echo '=================================================='
chmod 755 ./dbflute_maihamadb/manage.sh
cat << EOF > dbflute_maihamadb/playsql/data/ut/xls/defaultValueMap.dataprop
map:{
    ; REGISTER_DATETIME = sysdate
    ; REGISTER_USER     = root:ReplaceSchema
    ; UPDATE_DATETIME   = sysdate
    ; UPDATE_USER       = root:ReplaceSchema
    ; VERSION_NO        = 0
}
EOF

./dbflute_maihamadb/manage.sh replace-schema << EOF
y
EOF
