#!/bin/bash

sudo apt update
sudo apt upgrade -y

read -p "Introduce el nombre para el nuevo usuario (sin mayusculas): " usuario

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

read -p "Importante! La password del usuario es su nombre + 123 (usuario123). Enter para continuar con la instalacion de Webmin o Ctrl+C para salir. "

#Descargar e instalar Webmin con el archivo .deb
sudo wget https://www.webmin.com/download/deb/webmin-current.deb
sudo apt-get install --install-recommends ./webmin-current.deb

# Actualizado el 23/10/2025


