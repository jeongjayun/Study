import React, { Component } from "react";
import "./ToDoItem.css";

class ToDoItem extends Component {
  shouldComponentUpdate(nextProps, nextState) {
    return this.props.checked !== nextProps.checked;
  }

  render() {
    const { text, checked, id, onToggle, onRemove } = this.props;

    console.log(id);

    return (
      <div className="todo-item" onClick={() => onToggle(id)}>
        <div
          className="remove"
          onClick={(e) => {
            e.stopPropagation(); //onToggle이 실행되지 않게 한다.
            onRemove(id);
          }}
        >
          &times;
        </div>

        <div className={`todo-text ${checked && "checked"}`}>
          <div>{text}</div>
        </div>

        {checked && <div className="check-mark"></div>}
      </div>
    );
  }
}

export default ToDoItem;
