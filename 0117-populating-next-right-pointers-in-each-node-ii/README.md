## 117. 填充每个节点的下一个右侧节点指针 II

给定一个二叉树

```java
class Node {
    int val;
    Node left;
    Node right;
    Node next;
}
```
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

![sss](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/15/117_sample.png)


### Solution

二叉树层序遍历，以上图为例：

新建一个Queue，使用`层序遍历`二叉树的方式，将数据写入队列中。
队列我们使用`LinkedList<Node>`，并将root直接写入队列

```java
Queue<Node> queue = new LinkedList<>();
queue.add(root);
```

使用表的形式表示队列：

|index|0|1|2|4|5|6|7|8|9|
| :--: | :--: |:--: |:--: |:--: |:--: |:--: |:--: |:--: |:--: |
| Node | 1 |    |    |    |    |    |    |    ||

嵌套第一个循环

```java
while (!queue.isEmpty()) {
    // 二叉树层序遍历，每次遍历都会添加每一行新的数据，所以除非遍历完，否则不会空。
}
```

在这个循环内第一步要做的事情是获取队列`queue`的`size`

```java
int size = queue.size(); //获取当前队列中已有的节点的数量
```

进入第二次循环

```java
while (!queue.isEmpty()) {
    int size = queue.size();
    while (size-- > 0){
        // 大的循环每一次都是一层，每一层，我们循环将节点的Next指向下一个节点
        Node node = queue.remove();
        if (size > 0) {
            node.next = queue.peek();
        }
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}
```

### 第一次循环

1. 得到size = 1
2. size = 1 > 0  进入循环，size 变为0
3.  Node node= queue.remove(); 得到当前队列中的节点 `node`
4. 判断当前size 不大于0 ，则不进行`node.next`指向操作
5. 将`node`不为空的左节点存入队列，将不为空的右节点存入队列

则当前队列内容为：

|index|0|1|2|4|5|6|7|8|9|
| :--: | :--: |:--: |:--: |:--: |:--: |:--: |:--: |:--: |:--: |
| Node | 2 |  3  |    |    |    |    |    |    ||


### 第二次循环

1. 得到size = 2
2. size = 2 > 0  进入循环，size 变为1
3. Node node= queue.remove(); 得到当前队列中的节点 `node`， 因为弹出了第一个节点，当前队列为：

|index|0|1|
| :--: | :--: |:--: |
| Node | 3 |    |

4. 判断当前size 大于0 ，则进行`node.next`指向操作  node.next = queue.peek() ，那么2 就 指向了 3，但是3没有弹出。
5. 将`node`不为空的左节点存入队列，将不为空的右节点存入队列，则当前队列为：

|index|0|1|2|
| :--: | :--: |:--: |:--: |
| Node | 3 | 4 |5|

6. 继续循环，size = 1 > 0 ,进入二层循环，size 变为0
7. Node node= queue.remove(); 得到当前队列中的节点 `node`

|index|0|1|2|
| :--: | :--: |:--: |:--: |
| Node | 4 | 5 ||

8. 判断当前size 不大于0 ，则不进行`node.next`指向操作，所以 3 指向的是`Null`
9. 将3的左右孩子存入队列：

|index|0|1|2|
| :--: | :--: |:--: |:--: |
| Node | 4 | 5 |7|

10. 内层循环结束，开始新的一轮循环，直到所有的节点都指向正确的Next节点。