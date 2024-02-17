import React, { Component } from "react";
import ToDoItem from "./ToDoItem";

class ToDoItemList extends Component {
  shouldComponentUpdate(nextProps, nextState) {
    //shouldComponentUpdate:
    //컴포넌트 라이프 사이클 메소드 중 하나
    //컴포넌트가 리렌더링을 할 지 말지 정함
    //따로 구현하지 않으면 언제나 true 반환
    return this.props.todos !== nextProps.todos;
  }

  render() {
    const { todos, onToggle, onRemove } = this.props;

    const todoList = todos.map(({ id, text, checked }) => (
      <ToDoItem
        id={id}
        text={text}
        checked={checked}
        onToggle={onToggle}
        onRemove={onRemove}
        key={id}
      />
    ));

    return <div>{todoList}</div>;
  }
}

export default ToDoItemList;
