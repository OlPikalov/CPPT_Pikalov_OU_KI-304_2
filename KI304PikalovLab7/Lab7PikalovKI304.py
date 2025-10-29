import sys

rows_num = int(input("Введіть розмір квадратної матриці: "))
filler = input("Введіть символ-заповнювач: ")

if len(filler) == 0:
    print("Не введено символ-заповнювач")
    sys.exit(1)
elif len(filler) > 1:
    print("Забагато символів-заповнювачів")
    sys.exit(1)

width = 1 if rows_num < 6 else rows_num // 6 + 1

lst = []
for i in range(rows_num):
    row = []
    for j in range(rows_num):
        if i < width or i >= rows_num - width:
            row.append(filler)
        elif j < width or j >= rows_num - width:
            row.append(filler)
        else:
            row.append(' ')
    lst.append(row)

lst.reverse()
for row in lst:
    print(' '.join(row))
