# SSL Example - Self Signed Certificate

## Terminology
   	SSL
   	– stands for Secure Sockets Layer. It is the industry standard protocol for keeping an internet connection secure by safeguarding all sensitive data that is being sent between two systems, preventing hackers from reading and modifying any information transferred.
   
   	TLS
   		– (Transport Layer Security) is an updated, more secure, version of SSL. It adds more features. Today, certificates provided by certificate authorities are based on TLS only. But regarding secured communication over network, the term SSL is still common as it is the old and just become popular among community.
   
   	HTTPS
   		– (Hyper Text Transfer Protocol Secure) appears in the URL when a website is secured by an SSL certificate. It is the secured version of HTTP protocol.
   
   	Truststore and Keystore
   		– Those are used to store SSL certificates in Java but there is little difference between them. truststore is used to store public certificates while keystore is used to store private certificates of client or server.
   
## Command
   	keytool -genkey -alias selfsigned_localhost_sslserver -keyalg RSA -keysize 2048 -validity 700 -keypass storeit -storepass storeit -keystore ssl-server.jks
   	keytool -list -keystore ssl-server.jks
   	keytool -export -alias selfsigned_localhost_sslserver -file ssl-server.crt -keystore ssl-server.jks