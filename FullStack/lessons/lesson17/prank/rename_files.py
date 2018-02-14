import os
def rename_files():
    fileList = os.listdir(r".")
    for fileName in fileList:
        os.rename(fileName, fileName.translate(None, "0123456789")

rename_files()
