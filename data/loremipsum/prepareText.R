library(stringi)
lines <- readLines("raw.txt", warn = FALSE)
lines <- lines[nchar(lines) > 0]
lines <- unlist(strsplit(tolower(lines), split = "\\."))

lines <- stri_trim(lines) 
lines <- stri_replace_all_regex(lines, pattern = ",", replacement = "")
cat(lines, sep = "\n", file = "text.txt")
