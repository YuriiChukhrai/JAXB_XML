#!/bin/sh
# ========================================
GITHUB_ACCOUNT=YuriiChukhrai
WS_DIR=Documents/Workspace
REPO_NAME=JAXB_XML
APP_VERSION=1.1
#MAIN_CLASS=core.App
#ARGS_01=
# ========================================
# ========================================
# GITHUB_ACCOUNT=$1
# WS_DIR=$2
# REPO_NAME=$3
# APP_VERSION=$4
# MAIN_CLASS=$5
# ARGS_01=$6
# ========================================

# if ! which java >/dev/null 2>&1 ; then echo Java not installed; return; fi
# if ! which mvn >/dev/null 2>&1 ; then echo Maven not installed; return; fi
# if ! which git >/dev/null 2>&1 ; then echo Git not installed; return; fi

if which java >/dev/null 2>&1 ; then java -version &>jv.txt;grep "java version" jv.txt | awk '{print $1,$3}'; else echo Java not installed; return; fi
if which mvn >/dev/null 2>&1 ; then mvn --version &>mv.txt; grep "Apache Maven" mv.txt | awk '{print $2,$3}'; else echo Maven not installed; return; fi
if which git >/dev/null 2>&1 ; then git --version &>gv.txt; grep "git version" gv.txt | awk '{print $1,$3}'; else echo Git not instlled; return; fi

if [ -d "$HOME/$WS_DIR" ] ; then cd ~/$WS_DIR; else echo $WS_DIR directory is not exist; return; fi

if [ -d "$HOME/$WS_DIR/$REPO_NAME" ]; then rm -rf $HOME/$WS_DIR/$REPO_NAME; fi

git clone https://github.com/$GITHUB_ACCOUNT/$REPO_NAME.git

cd ./$REPO_NAME

mvn package -Dapp.vers=$APP_VERSION
echo "Executing Java programm ..."

echo "JAXB_XML Single Element ..."
java -cp $HOME/$WS_DIR/$REPO_NAME/target/$REPO_NAME-$APP_VERSION-jar-with-dependencies.jar core.PeopleParsing

echo "JAXB_XML List Elements ..."
java -cp $HOME/$WS_DIR/$REPO_NAME/target/$REPO_NAME-$APP_VERSION-jar-with-dependencies.jar core.PeopleSParsing

echo "JAXB_XML OkHttp..."
java -cp $HOME/$WS_DIR/$REPO_NAME/target/$REPO_NAME-$APP_VERSION-jar-with-dependencies.jar core.PeopleParsingOkHttp