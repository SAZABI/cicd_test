FROM websphere-liberty:webProfile7

ADD target/crmci_channel-0.0.1-SNAPSHOT.jar /config/dropins/

EXPOSE 9080

ENV LICENSE accept
