import { defineConfig } from 'vite';

export default defineConfig({
  plugins: [
    // 기존 플러그인들을 여기에 추가합니다.
    // CSS 플러그인 추가
    {
      name: 'css',
      // v-calendar의 CSS 파일 경로 지정
      apply: 'build',
      transformIndexCss: true,
      transform(css, id) {
        if (id.includes('v-calendar')) {
          return css.replace("@import './lib/v-calendar.min.css';", '');
        }
      },
    },
  ],
});
