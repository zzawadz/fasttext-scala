~/fastText/fasttext skipgram -input text.txt -thread 1 -output loremModel -dim 10 -minn 3 -maxn 6
tar -czvf loremModel.tar.gz loremModel.bin