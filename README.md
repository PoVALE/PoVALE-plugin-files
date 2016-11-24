# PoVALE-plugin-files
Plugin for file management

## Exported entities

* `File`
* `Directory` which extends `File.

## Exported predicates

* `is-directory?(File)`: it is satisfied when the given file is a directory.

## Exported functions

* `name(File) : StringEntity`: name of a file (including extension).
* `base-name(File) : StringEntity`: name of a file (excluding extension).
* `extension(File) : StringEntity`: extension of a file.
* `files(Directory) : ListEntity`: regular files contained within the given directory.
* `files-rec(Directory) : ListEntity`: regular files contained within the given directory and its subdirectories.
* `children(Directory) : ListEntity`: files and directories directly contained within the given directory.
* `children-rec(Directory) : ListEntity`: files and directories contained within the given directory and its subdirectories.
