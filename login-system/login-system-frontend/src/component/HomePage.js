import React, { useState } from 'react';
import { FaShoppingCart, FaUser } from 'react-icons/fa';
import './design/HomePage.css';

function HomePage({ user, onLogout }) {
  const [isUserMenuOpen, setUserMenuOpen] = useState(false);

  const toggleUserMenu = () => {
    setUserMenuOpen(!isUserMenuOpen);
  };

  return (
    <div className="home-page">
      <nav className="navbar">
        <span>Ciao {user.firstname}!</span>
        <div className="nav-icons">
          <FaUser className="user-icon" onClick={toggleUserMenu} />
          {isUserMenuOpen && (
            <div className="custom-menu">
              <ul>
                <li>Profilo</li>
                <li>News</li>
                <li onClick={onLogout}>Logout</li>
              </ul>
            </div>
          )}
          <FaShoppingCart className="cart-icon"/>
        </div>
      </nav>
      <header>
        <h1>Welcome, {user.firstname}!</h1>
      </header>
      <main>{}</main>
    </div>
  );
}

export default HomePage;

