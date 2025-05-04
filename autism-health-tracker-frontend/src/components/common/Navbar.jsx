// src/components/common/Navbar.jsx
import React from 'react';
import { useAuthContext } from '../../contexts/AuthContext';
import { useNavigate } from 'react-router-dom';
import authService from '../../services/authService';

const Navbar = () => {
  const { user, logout } = useAuthContext();
  const navigate = useNavigate();

  const handleLogout = () => {
    authService.logout();
    logout();
    navigate('/login');
  };

  return (
    <nav className="bg-blue-600 text-white p-4 flex justify-between items-center">
      <h3 className="text-xl font-semibold">Autism Tracker</h3>
      {user && (
        <div className="flex items-center gap-4">
          <span>Welcome, {user.name}</span>
          <button
            className="bg-red-500 hover:bg-red-600 px-4 py-1 rounded"
            onClick={handleLogout}
          >
            Logout
          </button>
        </div>
      )}
    </nav>
  );
};

export default Navbar;
