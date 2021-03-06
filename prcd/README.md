# PRCDのローカルPC上での起動手順書
## ローカル環境の事前準備
### hostsの設定
 -`C:\Windows\System32\drivers\etc\hosts`に以下の設定を追加する。
  - `127.0.0.1 tera-ci.net`



### TomcatのSSL設定（WTP）※pom.xmlからcargo起動の場合は設定済みのため不要
  - `${workspace_loc}/Servers/[使用しているTomcat]/server.xml`

         <Connector SSLEnabled="true" clientAuth="false" keystoreFile="${user.home}/.keystore"
         keystorePass="aaaaaa" maxThreads="200" port="8082" protocol="org.apache.coyote.http11.Http11NioProtocol" scheme="https" secure="true" sslProtocol="TLS"/>

  - `/prcd/file/.keystore`を`${user.home}`に配置する。


### private-keyの配置
  - `s3://functionaltest.private.cache.distribution/private-key.der`を`${user.home}`に配置する。
     別の環境で動かす場合は、信頼された署名者の CloudFront キーペアを作成する必要があります。
     http://docs.aws.amazon.com/ja_jp/AmazonCloudFront/latest/DeveloperGuide/private-content-trusted-signers.html#private-content-creating-cloudfront-key-pairs

## AWSの事前準備
### S3にコンテンツの配置
 - `/prcd/src/test/resources/testdata`の配下にテスト用のファイルがあるのでS3の以下に配置
   - `functionaltest.private.cache.distribution/prcd/paid/2.png`
   - `functionaltest.private.cache.distribution/prcd/reject/1.png`


作成したバケットはテストの為にCORSの設定を行う。
※以下はサンプル

    <?xml version="1.0" encoding="UTF-8"?>
    <CORSConfiguration xmlns="http://s3.amazonaws.com/doc/2006-03-01/">
    <CORSRule>
        <AllowedOrigin>https://XXXX.net</AllowedOrigin>
        <AllowedOrigin>http://XXXX.net</AllowedOrigin>
        <AllowedOrigin>http://XXXX.net:8082</AllowedOrigin>
        <AllowedOrigin>https://XXXX.net:8082</AllowedOrigin>
        <AllowedMethod>GET</AllowedMethod>
        <AllowedMethod>HEAD</AllowedMethod>
        <MaxAgeSeconds>3000</MaxAgeSeconds>
        <AllowedHeader>Content-*</AllowedHeader>
        <AllowedHeader>Host</AllowedHeader>
        <AllowedHeader>*</AllowedHeader>
    </CORSRule>
    </CORSConfiguration>

### CloudFrontの設定
今回は`tera-ci.net`をドメイン名としてクラウドフロント側のサブドメイン`www.tera-ci.net`でアクセスするための設定を行っている。ドメインの変更は`/prcd/src/main/resources/application.yml`に設定することで変更可能

    functionaltest:
      cf:
        signature:
          protocol: https
          secure: true
          domain: tera-ci.net
          distributionDomain: www.tera-ci.net

####CloudFront側の設定は以下のAWSのドキュメントを参考に設定する

#####CloudFront を使用してプライベートコンテンツを供給する
http://docs.aws.amazon.com/ja_jp/AmazonCloudFront/latest/DeveloperGuide/PrivateContent.html
#####CloudFront で HTTPS を使用する
http://docs.aws.amazon.com/ja_jp/AmazonCloudFront/latest/DeveloperGuide/using-https.html
#####Amazon S3 での CloudFront の使用
http://docs.aws.amazon.com/ja_jp/AmazonCloudFront/latest/DeveloperGuide/MigrateS3ToCloudFront.html
#####代替ドメイン名と HTTPS の使用
http://docs.aws.amazon.com/ja_jp/AmazonCloudFront/latest/DeveloperGuide/using-https-alternate-domain-names.html

