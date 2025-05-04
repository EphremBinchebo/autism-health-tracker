import axios from '../api/axiosInstance';

// Login function
const login = async (credentials) => {
  try {
    const response = await axios.post('/auth/login', credentials);
    if (response.data?.token) {
      localStorage.setItem('token', response.data.token);
    }
    return response.data;
  } catch (error) {
    throw error;
  }
};

// Logout function
const logout = () => {
  localStorage.removeItem('token');
};

// Exporting as a named object
const authService = {
  login,
  logout,
};

export default authService;
