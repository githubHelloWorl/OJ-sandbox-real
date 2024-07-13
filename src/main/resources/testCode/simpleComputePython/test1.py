import sys

# 定义一个函数来执行两数相加
def add_two_numbers(num1, num2):
    return num1 + num2

if len(sys.argv) != 3:
    print("使用方法: python3 test.py <number1> <number2>")
    sys.exit(1)

                # 从命令行参数获取两个数字
                # sys.argv[0] 是脚本名称，sys.argv[1] 和 sys.argv[2] 是数字
first_number = float(sys.argv[1])
second_number = float(sys.argv[2])

                # 调用函数并打印结果
result = add_two_numbers(first_number, second_number)
print(f"{result}")
