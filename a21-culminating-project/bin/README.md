# Folder Information [IMPORTANT]

DO NOT CREATE ANY JAVA FILES IN THE DEFAULT PACKAGE! ONLY FINAL VERSION WILL BE PLACED HERE!

To keep things organized, either create a new package for what is specifically being stored or place the Java file
in the corresponding package, with backups being placed in version folders within their respective packages...

Make sure to have the versions being worked on stored in their respective version types (alpha, beta, pre-release), with any older versions being backed-up according to the rules listed in the package README.md! 

Version Number Info:
- 0.0.# --> Alpha
- 0.#.# --> Beta
- 1.0.0-preRelease## --> Pre-Release
- 1.0.0 --> Release/Final

Backup Information:
- Go the "backups" folder located in the root directory
- Create a folder containing the version number of the previous version (ex. 0.0.1)
- Copy the Java Class file into the backup folder
- Change the version number of the current Java Class file, following the numbering rules for its respective package 

Present Java Class files will be listed in the root of the package...

Whenever making a major change to the program, make sure to explicitly state what is changed/added for clarity purposes. Within the code itself, there should be a "Patch Notes" 
comment created. Use that comment field to state what was changed/created. State the line number if possible, as well as the date the change was made. Will allow for
easier tracking of what was done, so other collaborators may be able to know what is going on.