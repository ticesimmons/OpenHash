# dev issues

OpenHash.java line 177 

| for (int i = y; i <= x; i++) |

for some reason, when this is run with i < 1, the string "asdkhbfkhjfkhjf"
will process to a 3 digit key, other tested strings will process to a 4 digit key.

when it is run as written, will occasionally output a 5 digit key, I have no idea why 
