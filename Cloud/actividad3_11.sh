#!/bin/bash

sudo apt update
sudo apt upgrade -y

read -p "Introduce nombre de usuario" usuario

#Asignar usuario manualmente
sudo adduser --gecos "" --disabled-password "$usuario"

#Asignnar contrasena automaticamente
pass="${usuario}123"
echo "$usuario:$pass" | sudo chpasswd

#Agregar usuario a grupo sudo
sudo usermod -aG sudo $usuario

#Imprimir por pantalla lo hecho
echo $usuario
groups "$usuario"

read -p "Enter para continuar"

#Descargar e instalar Webmin con el archivo .deb
sudo wget https://www.webmin.com/download/deb/webmin-current.deb
sudo apt-get install --install-recommends ./webmin-current.deb

# Actualizado el 23/10/2025


