class MyQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    /**
     *  mainStack tells us what stack is currently being used
     **/
    private Stack<Integer> mainStack;
    
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
        mainStack = pushStack;
    }
    
    public void push(int x) {
        if (mainStack == popStack) {
            changeMainStack();
        }
        mainStack.push(x);
    }
    
    public int pop() {
        if (mainStack == pushStack) {
            changeMainStack();
        }
        return mainStack.pop();
    }
    
    public int peek() {
        if (mainStack == pushStack) {
            changeMainStack();
        }
        return mainStack.peek();
    }
    
    public boolean empty() {
        return mainStack.isEmpty();
    }

    private void changeMainStack() {
        if (mainStack == pushStack) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
            mainStack = popStack;
        } else if (mainStack == popStack) {
            while (!popStack.empty()) {
                pushStack.push(popStack.pop());
            }
            mainStack = pushStack;
        }
    }
}