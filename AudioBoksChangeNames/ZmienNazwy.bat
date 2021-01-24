@ECHO OFF
REM This script runs java program NameConverter

REM This is path to program NameConverter
SET "NameConverterPath=C:\Users\artak\Exercism\java\NameConv\out\artifacts\NameConv_jar\NameConv.jar"

IF NOT EXIST %~dp0\%1 GOTO FolderMissing

IF NOT EXIST %NameConverterPath% GOTO ProgramMissing

:START
java -jar %NameConverterPath% %~dp0\%1
GOTO END

:ProgramMissing
ECHO NameConverter program is missing. Check path in script or administrator privileges.
GOTO END

:FolderMissing
ECHO No such folder
GOTO END

:END

REM PAUSE