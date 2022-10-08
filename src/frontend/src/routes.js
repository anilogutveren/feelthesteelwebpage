import { createWebHistory, createRouter } from "vue-router";
import HomePage from "./components/HomePage"
import AboutPage from './components/AboutPage'
import ContactPage from './components/ContactPage'
import PhotosPage from './components/PhotosPage'
import HeaderPage from './components/AppHeader'

export const routes = [
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
        path: "/photos",
        name: "photos",
        components: {
            default: PhotosPage
        }
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;

