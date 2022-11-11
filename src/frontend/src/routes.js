import { createWebHistory, createRouter } from "vue-router";
import HomePage from "./pages/HomePage"
import AboutPage from './components/About'
import ContactPage from './components/Contact'
import Gallery from './components/Gallery'
import HeaderPage from './components/AppHeader'
import LoginPage from './pages/LoginPage'

const routes = [
    {
        path: '/',
        name: 'HomePage',
        components: {
            default: HomePage,
            "header-top": HeaderPage
        }
    },
    {   path : "/about",
        name: "about",
        components: {
            default: AboutPage
        }
    },
    {   path : "/contact",
        name: "contact",
        components:{
            default: ContactPage
        }
    },
    {
        path: "/gallery",
        name: "gallery",
        components: {
            default: Gallery
        }
    }
    ,
    {
        path: "/login",
        name: "LoginPage",
        components: {
            default: LoginPage
        }
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;

