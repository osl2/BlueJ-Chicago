# Update bluej extension library

1.  Get the latest bluej version and install it
2.  Install the library `bluejext.jar` into this local repository:

```
PATH_TO_BLUEJ_INSTALL_DIR=${HOME}/bluej
VERSION=4.2.2
mvn install:install-file -Dfile=${PATH_TO_BLUEJ_INSTALL_DIR}/lib/bluejext.jar \
                         -DgroupId=bluej \
                         -DartifactId=bluejext \
                         -Dversion=${VERSION} \
                         -Dpackaging=jar \
                         -DlocalRepositoryPath=.
```

Example command:
```
mvn install:install-file "-Dfile=C:\Program Files\BlueJ\lib\bluejext.jar" -DgroupId=bluej -DartifactId=bluejext -Dversion=4.2.2 -Dpackaging=jar -DlocalRepositoryPath=./lib/
```
