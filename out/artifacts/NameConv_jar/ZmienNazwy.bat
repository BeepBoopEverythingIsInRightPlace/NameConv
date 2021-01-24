@ECHO OFF
REM Skrypt uruchamia porgram do zmiany plikow

IF NOT EXIST %~dp0\%1 GOTO BrakFolderu

IF NOT EXIST C:\Users\artak\Exercism\java\NameConv\out\artifacts\NameConv_jar\NameConv.jar GOTO BrakProgramu


:Uruchom
java -jar C:\Users\artak\Exercism\java\NameConv\out\artifacts\NameConv_jar\NameConv.jar %~dp0\%1
GOTO Koniec


:BrakProgramu
ECHO Nie znaleziono programu. Sprawdz sciezke do programu w skrypcie lub dostep administratora.
GOTO Koniec

:BrakFolderu
ECHO Nie ma takiego folderu
GOTO Koniec

:Koniec

REM PAUSE