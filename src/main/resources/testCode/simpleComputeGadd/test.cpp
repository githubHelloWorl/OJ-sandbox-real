#include <iostream>
using namespace std;

int main(int argc, char* argv[]) {
    // 检查命令行参数的数量是否正确
    if (argc != 3) {
        cout << "Usage: " << argv[0] << " <number1> <number2>" << endl;
        return 1; // 错误的参数数量
    }

    // 尝试将参数转换为整数
    int num1, num2;
    try {
        num1 = stoi(argv[1]);
        num2 = stoi(argv[2]);
    } catch (const invalid_argument& e) {
        cout << e.what();
        return 1; // 参数转换失败
    } catch (const out_of_range& e) {
        cout << "Out of range error: " << e.what() << endl;
        return 1; // 参数超出整数范围
    }

    // 计算两数之和
    int sum = num1 + num2;

    // 输出结果
    cout << sum << endl;

    return 0; // 正常退出
}
