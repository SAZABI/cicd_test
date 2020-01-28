FROM websphere-liberty:webProfile7

ADD target/crmci_channel.jar /config/dropins/

EXPOSE 9080

ENV LICENSE accept
