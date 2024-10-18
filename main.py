import tensorflow as tf
from keras import layers, models
import numpy as np
import matplotlib.pyplot as plt
from PIL import Image

# Tải dữ liệu MNIST
mnist = tf.keras.datasets.mnist
(x_train, y_train), (x_test, y_test) = mnist.load_data()

# Chuẩn hóa dữ liệu
x_train, x_test = x_train / 255.0, x_test / 255.0

# Thêm Data Augmentation
data_augmentation = tf.keras.Sequential([
    layers.RandomRotation(0.1),
    layers.RandomZoom(0.1),
])

# Áp dụng Data Augmentation cho dữ liệu huấn luyện
x_train_augmented = data_augmentation(x_train)

# Xây dựng mô hình mạng nơ-ron với nhiều lớp hơn
model = models.Sequential([
    layers.Flatten(input_shape=(28, 28)),
    layers.Dense(256, activation='relu'),  # Tăng số lượng nơ-ron từ 128 lên 256
    layers.Dropout(0.3),  # Tăng tỷ lệ dropout từ 0.2 lên 0.3
    layers.Dense(128, activation='relu'),  # Thêm một lớp ẩn mới
    layers.Dense(10, activation='softmax')
])

# Biên dịch mô hình
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# Huấn luyện mô hình với nhiều epochs hơn
model.fit(x_train_augmented, y_train, epochs=200)  # Tăng số lượng epochs từ 5 lên 10

# Đánh giá mô hình trên dữ liệu test
test_loss, test_acc = model.evaluate(x_test, y_test)

print(f'\nĐộ chính xác trên tập kiểm tra: {test_acc}')

# Đọc ảnh từ file image.png
image = Image.open('image.png').convert('L')
image = image.resize((28, 28))
image = np.array(image) / 255.0
image = np.expand_dims(image, axis=0)

# Dự đoán chữ số từ ảnh đầu vào
predictions = model.predict(image)
predicted_digit = np.argmax(predictions[0])

# Hiển thị hình ảnh và dự đoán
plt.imshow(image[0], cmap=plt.cm.binary)
plt.title(f'Dự đoán: {predicted_digit}')
plt.show()
