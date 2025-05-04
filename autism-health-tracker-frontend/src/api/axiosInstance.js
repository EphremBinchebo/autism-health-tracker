import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080/api/autism-tracker/', // Change this to your actual backend base URL
  headers: {
    'Content-Type': 'application/json',
  },
});

// Add JWT token to requests if it exists
axiosInstance.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

export default axiosInstance;
