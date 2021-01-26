import urllib.request

# Adding information about user agent
opener=urllib.request.build_opener()
opener.addheaders=[('User-Agent','Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1941.0 Safari/537.36')]
urllib.request.install_opener(opener)
image_url_prefix = "https://img.erogazou-pinkline.com/wp-content/uploads/2015/10/suzuki_koharu-1278-"
filename_prefix = "/Users/victorzhao/Desktop/test/2015_"
# setting filename and image URL
# image_url = "https://img.erogazou-pinkline.com/wp-content/uploads/2015/10/suzuki_koharu-1278-002.jpg"
# filename = "/Users/victorzhao/Desktop/test/1.jpg"

for i in range(2, 241):
	image_url = image_url_prefix
	filename = filename_prefix + str(i - 1) + ".jpg"
	if i < 10:
		image_url = image_url + "00" + str(i) + ".jpg"
	elif i < 100:
		image_url = image_url + "0" + str(i) + ".jpg"
	else:
		image_url = image_url + str(i) + ".jpg"
	urllib.request.urlretrieve(image_url, filename)


