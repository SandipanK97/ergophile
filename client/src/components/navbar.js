import React from 'react';

const navbar = (props) => {
  return (
    <nav>
      <div className="menu">
            <div class="logo">
                <a href="/">Portfolio</a>
            </div>
                     <ul>
                        <li><a href="/">Home</a></li>
                        <li><a href="/career">Career</a></li>
                        <li><a href="/contact">Contact</a></li>
                        <li><a href="/login">{props.status}</a></li>
                     </ul>
        </div>
    </nav>
  );
};

export default navbar;
